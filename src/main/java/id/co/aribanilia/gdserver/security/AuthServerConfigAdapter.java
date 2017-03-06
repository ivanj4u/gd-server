package id.co.aribanilia.gdserver.security;

import id.co.aribanilia.gdserver.dao.ClientDao;
import id.co.aribanilia.gdserver.entity.Client;
import id.co.aribanilia.gdserver.util.GDConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;

/**
 * Created by ivan_j4u on 2/23/2017.
 */
@Configuration
@EnableAuthorizationServer
public class AuthServerConfigAdapter extends AuthorizationServerConfigurerAdapter {
    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    @Qualifier("userDetailsServiceBean")
    private UserDetailsService userDetailsService;

    @Autowired
    private ClientDao clientDao;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        /**
         * Client Admin
         */
        Client admin = clientDao.findByClientId(GDConstants.CLIENT.ADMIN);
        if (admin == null)
            throw new Exception("Client not Found");
        Client user = clientDao.findByClientId(GDConstants.CLIENT.USER);
        if (user == null)
            throw new Exception("Client not Found");
        clients.inMemory()
                .withClient(admin.getClientId())
                .authorities(GDConstants.AUTHORITIES.APPLICATION_WEB)
                .secret(admin.getPassword())
                .authorizedGrantTypes("authorization_code", "refresh_token")
                .scopes(GDConstants.SCOPE.MODULE_GADAI, GDConstants.SCOPE.MODULE_HARGA)
                .accessTokenValiditySeconds(admin.getTokenValidity())
                .and()
                .withClient(user.getClientId())
                .authorities(GDConstants.AUTHORITIES.APPLICATION_WEB)
                .secret(user.getPassword())
                .authorizedGrantTypes("password")
                .scopes(GDConstants.SCOPE.MODULE_GADAI, GDConstants.SCOPE.MODULE_HARGA)
                .accessTokenValiditySeconds(user.getTokenValidity())
                .autoApprove(true);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess(GDConstants.AUTHORITIES.HAS_AUTHORITY_WEB)
                .tokenKeyAccess("permitAll()");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .accessTokenConverter(jwtTokenConverter())
                .authenticationManager(authenticationManager).userDetailsService(userDetailsService);
    }

    @Bean
    public JwtAccessTokenConverter jwtTokenConverter(){
        JwtAccessTokenConverter conv = new JwtAccessTokenConverter();
        KeyPair keyPair = new KeyStoreKeyFactory(
                new ClassPathResource("gadai.jks"), "gadai123".toCharArray())
                .getKeyPair("gadai");
        conv.setKeyPair(keyPair);
        return conv;
    }
}