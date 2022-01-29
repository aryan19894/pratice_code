package com.bot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MakeCompatibleDefaultCode {

    private static final String projectPath = "E:\\code\\DSA\\Platform\\src\\main\\java\\";
    private static final String basePkgPath = "com\\striver\\DSAExperience\\";
    private static final String basePkgFullPath = projectPath + basePkgPath;
    private static final String pkgName = "T9StackQueue\\";
    private static String entityName = "DefaultClassName";

    private static final boolean methodCall = true;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the entityName: ");
        entityName = in.nextLine();
        File file = new File(basePkgFullPath + pkgName + entityName + ".java");
        ArrayList<String> content = readFile(file);
        content = cleanContent(content);
        if (!content.get(0).contains("package")) {
            content = modifyContent(content);
            appendContent(file, toString(content));
        }
        System.out.println("Process Complete");
    }



    private static ArrayList<String> modifyContent(ArrayList<String> content) {
        ArrayList<String> ref = new ArrayList<>();
        ref.add("package " + toPkg(basePkgPath + pkgName) + ";");
        ref.add("");
        content.remove(0);
        content.remove(content.size() - 1);
        ref.addAll(content);

//        int startIdx = Integer.parseInt(clsDetail.get("startIdx"));
//        int endIdx = Integer.parseInt(clsDetail.get("endIdx"));
//        for (int i = startIdx; i <= endIdx; i++)
//            ref.add(content.get(i));
//        ref.add("");
        ref.add("public class " + entityName + " {");
        ref.add("\tpublic static void main(String[] args) {");
        ref.add("");
        if (methodCall) {
            ref.add("\t\tSolution sol = new Solution();");
            HashMap<String, String> clsDetail = analyzeClass(content); // class, no of argument, return type
            List<String> arguments = analyzeMethodArgument(clsDetail.get("argumentType"));

            String callingArgument = "";
            for (String args : arguments) {
                String t[] = args.trim().split(" ");
                callingArgument += t[1] + ", ";
                if (requireNewKeyword(args))
                    ref.add("\t\t" + args + " = new " + t[0] + ";");
                else if (args.contains("[][]"))
                    ref.add("\t\t" + args + " = {{}};");
                else if (args.contains("[]"))
                    ref.add("\t\t" + args + " = {};");
                else
                    ref.add("\t\t" + args.trim() + " = " + defaultValue(t[0]) + ";");
            }

            callingArgument = callingArgument.substring(0, callingArgument.length() - 2);
            String callingMethod = "sol." + clsDetail.get("methodName") + "(" + callingArgument + ")";
            String returnType = clsDetail.get("returnType");
            if (requireNewKeyword(returnType) || returnType.contains("[]")) {
                ref.add("\t\t" + returnType + " res = " + callingMethod + ";");
                ref.add("\t\tPrinter.print(res);");

                ref.add(2, "import com.common.Printer;");
                ref.add(3, "");
            } else
                ref.add("\t\tSystem.out.println(" + callingMethod + ");");
        }

        ref.add("\t}");
        ref.add("}");

        return ref;
    }

    private static String defaultValue(String s) {
        if (s == null) return null;
        if (s.contains("int")) return "0";
        if (s.contains("double")) return "0.0";
        if (s.contains("char")) return "\'\'";
        if (s.contains("String")) return "\"\"";
        return "";
    }

    private static boolean requireNewKeyword(String args) {
        String argsLower = args.toLowerCase();
        if (argsLower.contains("list") ||
                argsLower.contains("set") ||
                argsLower.contains("map"))
            return true;
        return false;
    }

    private static List<String> analyzeMethodArgument(String argumentType) {
        List<String> arguments = new ArrayList<>();
        String[] t3 = argumentType.split(",");
        for (int i = 0; i < t3.length; i++) {
            arguments.add(t3[i].trim());
        }
        return arguments;
    }

    private static HashMap<String, String> analyzeClass(ArrayList<String> content) {
        HashMap<String, String> map = new HashMap<>();
        int clsId = 0;
        for (int i = 0; i < content.size(); i++) {
            String cont = content.get(i).toLowerCase();
            if (cont.contains("class")) {
                map.put("class", "" + i);
                clsId = i;
                break;
            }
        }
        String method = content.get(clsId + 1);
        String[] t1 = method.split("\\(");

        String[] t2 = t1[0].trim().split(" ");
        map.put("returnType", t2[1]);
        map.put("methodName", t2[t2.length - 1]);

        map.put("argumentType", t1[1].replace(") {", "").trim());


        return map;
    }

    private static String toString(ArrayList<String> content) {
        String data = "";
        for (String c : content)
            data += c + "\n";
        return data;
    }

    private static String toPkg(String s) {
        if (s != null) {
            String d = s.replaceAll("\\\\", ".");
            d = d.substring(0, d.length() - 1);
            return d;
        }
        return null;
    }

    private static void appendContent(File file, String content) {
        try {
            FileWriter myWriter = new FileWriter(file);
            myWriter.write(content);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static ArrayList<String> readFile(File file) {
        ArrayList<String> content = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);    //file to be scanned
            while (sc.hasNextLine()) {
                String c = sc.nextLine();
                if(!c.contains("*"))
                    content.add(c);
            }
            sc.close();     //closes the scanner
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    private static ArrayList<String> cleanContent(ArrayList<String> content) {
        ArrayList<String> ref = new ArrayList<>();
        for(String c: content){
            if(!c.contains("*"))
                ref.add(c);
        }
        if(ref.get(0).isEmpty())
            ref.remove(0);
        if(ref.get(ref.size()-1).isEmpty())
            ref.remove(ref.size()-1);

        return ref;
    }
}
