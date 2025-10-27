class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.length() < 7) return "Neither";
        boolean type = false;
        if (queryIP.contains(":")) type = true;
        if (queryIP.charAt(queryIP.length() - 1) == '.' || queryIP.charAt(queryIP.length() - 1) == ':') return "Neither";
        if (queryIP.charAt(0) == '.' || queryIP.charAt(0) == ':') return "Neither";

        if (!type) {
            String ips[] = queryIP.split("\\.");
            if (ips.length != 4) return "Neither";
            for (String ip : ips) {
                if (ip.length() > 1 && ip.charAt(0) == '0') return "Neither";
                try {
                    if (Integer.parseInt(ip) > 255) return "Neither";
                }
                catch (Exception e) {
                    return "Neither";
                }
            }
            return "IPv4";
        }
        else {
            String ips[] = queryIP.split(":");
            if (ips.length != 8) return "Neither";
            for (String ip : ips) {
                if (ip.length() > 4 || ip.length() < 1) return "Neither";
                if (!ip.matches("^[0-9A-Fa-f]+$")) return "Neither";
            }
            return "IPv6";
        }
    }
}