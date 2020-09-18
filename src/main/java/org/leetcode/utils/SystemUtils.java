package org.leetcode.utils;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.*;

public class SystemUtils {
    public static int getPid() {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String name = runtime.getName(); // format: "pid@hostname"
        System.out.println(name);
        try {
            return Integer.parseInt(name.substring(0, name.indexOf('@')));
        } catch (Exception e) {
            return -1;
        }
    }
    
    public static String timeMillisToHumanString(final long t) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(t);
        return String.format("%04d%02d%02d%02d%02d%02d%03d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1,
            cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND),
            cal.get(Calendar.MILLISECOND));
    }
    public static void main(String[] args) {
		System.out.println(getPid());
		System.out.println(timeMillisToHumanString(3));
		
	}
  
}
