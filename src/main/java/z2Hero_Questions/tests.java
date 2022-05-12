package z2Hero_Questions;

public class tests {

    public static void main(String[] args) {
        String classInfo = "US Morning";
        String result = "";

        if (classInfo == "US Morning" || classInfo == "US Evening" || classInfo == "EU") {
            // } else
            if (classInfo == "US Morning") {
                result = "Class times are 10-5 EST. M, T, Th, F.";
            } else if (classInfo == "US Evening") {
                result = "Class times are 7-10 EST. M, T, W, Th, S, S";
            } else if (classInfo == "EU") {
                result = "Class times are  10-5 EST. M, T, W, Th, F.";
            } else {
                result = "Invalid Info";
            }
        }
        System.out.println(result);
    }

}
