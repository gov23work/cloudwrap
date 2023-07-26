import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        System.out.println("----------------------");
        System.out.println("Welcome to Cloudwrap!");
        System.out.println("----------------------");

        Scanner scanTool = new Scanner(System.in);
        Parser parseTool = new Parser();
        Wrapper wrapTool = new Wrapper();
        String cloudFunction1 = "";
        String cloudFunction2 = "";
        /*
        //ask for cloud
        boolean cloudLoop = true;
        while(cloudLoop) {
            System.out.println("Please provide the cloud provider you want to utilize, type 'aws' for AWS or 'gcp' for GCP:");
            //TODO
            String cloud = scanTool.nextLine();
            if(cloud == "gcp" || cloud.equals("aws")) cloudLoop = false;
            else cloudLoop = true;
        }

        */
        //ask for first folder
        boolean firstFolderLoop = true;
        while(firstFolderLoop) {
            System.out.println("Please provide the path to the first cloud function folder. Please provide an absolute path, or place the folder in the input folder :");
            //TODO
            String firstFolder = scanTool.nextLine();
            cloudFunction1 = parseTool.checkValidity(firstFolder);
            if(cloudFunction1 == "NF") firstFolderLoop = true;
            else firstFolderLoop = false;
        }

        //ask for second folder
        boolean secondFolderLoop = true;
        while(secondFolderLoop) {
            System.out.println("Please provide the path to the second cloud function folder. Please provide an absolute path, or place the folder in the input folder :");
            String secondFolder = scanTool.nextLine();
            //TODO
            cloudFunction2 = parseTool.checkValidity(secondFolder);
            if (cloudFunction2 == "NF") secondFolderLoop = true;
            else secondFolderLoop = false;
        }
        if(cloudFunction1.substring(cloudFunction1.indexOf(".")).equals(cloudFunction2.substring(cloudFunction2.indexOf(".")))){
            System.out.println("Proceeding with building of wrapper function using "+ cloudFunction1 + " and "+ cloudFunction2);
            wrapTool.buildWrapper(cloudFunction1, cloudFunction2);
        }else{
            //function type mismatch, abort
            System.out.println("Functions are of different types "+ cloudFunction1.substring(cloudFunction1.indexOf(".")) + " and "+ cloudFunction2.substring(cloudFunction2.indexOf(".")) + ", aborting Cloudwrap.");
            exit(1);
        }
        /*
        //ask for deployment type
        boolean deployLoop = true;
        while(deployLoop) {
            System.out.println("Do you want to deploy the wrapper AND both functions instead of just deploying the wrapper? (y/n)");
            //TODO
            String deploy = scanTool.nextLine();
            if(deploy.equals("y) || cloud.equals("n")){
                deployLoop = false;
            }
        }

        */
        //pass to shell script for tf deployment
        System.out.println("Passing variables to Terraform deployment script");
        String[] cmd = { "bash", "-c", "~/path/to/shellscript.sh foo bar" };
        try {
            Process p = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}