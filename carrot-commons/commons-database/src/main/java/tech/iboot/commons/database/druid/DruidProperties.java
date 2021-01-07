package tech.iboot.commons.database.druid;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author luohong
 * @date 2021/1/4
 */
@ConfigurationProperties(prefix = "tech.iboot.database.druid")
@Component
public class DruidProperties {
    private DruidConfigPOJO config = new DruidConfigPOJO();
    public DruidConfigPOJO getDruidConfigPOJO() {
        return config;
    }
    public void setConfig(DruidConfigPOJO config) {
        this.config = config;
    }
}
