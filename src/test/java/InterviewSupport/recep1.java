package InterviewSupport;

import java.util.*;

public class recep1 {
    public static void main(String[] args) {

        List<String> devicenames = Arrays.asList(new String[]{"switch","tv","switch","tv","switch","tv"});
        System.out.println(devicenames);
        System.out.println(devices(devicenames));

    }

    public static List<String > devices (List<String> devicenames) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap();

        for (int i = 0; i < devicenames.size(); i++) {
            String device = devicenames.get(i);
            if (!map.containsKey(device)) {
                map.put(device, map.getOrDefault(device, 0));
                result.add(device);
            } else {
                map.put(device, map.get(device) + 1);
                result.add(device + map.get(device));
            }
        }

        return result;
    }
/*
    public static List<String > devices1 (List<String> devicenames){
        List<String > result = new ArrayList<>();
        for (int i=0; i<devicenames.size(); i++){
            String device = devicenames.get(i);

            if (!result.contains(device)){

                result.add(device);
            } else {
                char ch1 = Character.isDigit(device.charAt(device.length()-2)) ? device.charAt(device.length()-2) : ' ';
                char ch2 = Character.isDigit(device.charAt(device.length()-1)) ? device.charAt(device.length()-1) : ' ';
                String digit = ""+ ch1 + ch2;
                digit = digit.replace(" ", "");
                int next =1;
                if (digit.length()>0) next += Integer.parseInt(digit);
                device += next;
                result.add(device);
            }
        }


        return result;
    }
*/
}
