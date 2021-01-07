package tech.iboot.commons.database.druid;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.iboot.commons.database.druid.DruidProperties;

/**
 * @author luohong
 * @date 2020/12/1
 */
@Configuration
public class DruidConfiguration {
    @Autowired
    private DruidProperties properties;

    @SuppressWarnings("unchecked")
    @Bean
    public ServletRegistrationBean statViewServlet() throws Exception {
        //创建servlet注册实体
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //设置ip白名单
        //servletRegistrationBean.addInitParameter("allow",allowIp);
        //设置ip黑名单，如果allow与deny共同存在时,deny优先于allow
        //servletRegistrationBean.addInitParameter("deny","192.168.0.19");
        //设置控制台管理用户
        //ConfigTools.decrypt()
        servletRegistrationBean.addInitParameter("loginUsername",properties.getDruidConfigPOJO().getLoginUsername());
        servletRegistrationBean.addInitParameter("loginPassword", ConfigTools.decrypt(properties.getDruidConfigPOJO().getLoginPassword()));
        //是否可以重置数据
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }

    public static void main(String[] args) throws Exception {
        String pravitekey = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAlLEjKq4lzbI3/FYW5rFfxmN5sXJeO1po04GqEC9YcVqRc4/1CWRkJqQam5Hwbtvv4lWnC2BVwHHwffSjTXm6xQIDAQABAkAQopCwobMRBDNHQ8pkHMv+QfrHY2gvc7nuj78a+HEInVFPi8Ro6H14M9KWw9SjA3HndaWGh8sXRXI0ALXcIkQBAiEA3VzMdc/9b4lTLyiY62c0Sf0sC0+1wgsLXTrkuri6r4UCIQCr9VjMA72aOqt2dj15jFSoKwJUOFaVas10WJulGE2iQQIgOYufR107iBxN+Kt4HXIl4LolEge1u2z9lk3yGixds7UCIQCL69zwTQ7nw1unzfihweVU3YJMo3cYp8o8JKmpgggRwQIhAJULA9DKLwlP9frvKl+WvGTFi8M/pT34/Y3085Vv9cja";
        String publickey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJSxIyquJc2yN/xWFuaxX8ZjebFyXjtaaNOBqhAvWHFakXOP9QlkZCakGpuR8G7b7+JVpwtgVcBx8H30o015usUCAwEAAQ==";
        String password = "dev_luohong@1993";
        String pa = ConfigTools.encrypt(pravitekey,password);
        String pa2 = ConfigTools.decrypt(publickey,"SBtvfgM2BCP6k2xKj7OD0hYXgkH4g7hTMIqPi1pb1kiiyY0EqiX9wwa+3IezYTKB+P5cObqlP+s+6afCp2yr5g==");
        System.out.println(pa);
        System.out.println(pa2);
    }
}
