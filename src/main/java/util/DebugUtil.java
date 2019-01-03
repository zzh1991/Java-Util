package util;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class DebugUtil {

    private static final String AGENTLIB_JDWP = "-agentlib:jdwp";

    public static boolean isDebugMode() {
        final RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        return runtimeMXBean.getInputArguments()
                .stream()
                .anyMatch(arg -> arg.contains(AGENTLIB_JDWP));

    }
}
