package com.zzh.util.util;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * @author zhihao zhang
 * @since 2020.03.22
 */

public class DebugUtil {

    private static final String AGENTLIB_JDWP = "-agentlib:jdwp";

    public static boolean isDebugMode() {
        final RuntimeMXBean mxBean = ManagementFactory.getRuntimeMXBean();
        return mxBean.getInputArguments()
                .stream()
                .anyMatch(arg -> arg.contains(AGENTLIB_JDWP));

    }
}
