package cn.honey.home.web.util;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Application;

public class EurekaInstanceUtils {

    @Deprecated
    public static String getEurekaServiceURI(Application application, String instanceId) {
        InstanceInfo instance = application.getByInstanceId(instanceId);
        return "http://" + instance.getAppName() + ":" + instance.getPort() + "/";
    }
}
