package de.holidayinsider.skimmy;

import sun.misc.IOUtils;

import java.io.*;
import java.util.Scanner;

/**
 * User: martinstolz
 * Date: 03.07.12
 *
 * This was the original Idea:

27.06.12 09:14 http://www.paulhammond.org/webkit2png/
27.06.12 09:15 python /Users/mfrischkorn/Applications/webkit2png/webkit2png -F -W 1280 -H 1024 --delay 0 -o detail_vacancy http://de.holidayinsider.com/unterkunftsverzeichnis/ferienwohnung-im-muehlengarten-kappel-grafenhausen-rus0031/available/16.06.2012/23.06.2012/people/2/?sp_id=2-FIT00020070000013036
27.06.12 09:25 python /Users/mfrischkorn/Applications/webkit2png/webkit2png -F -W 1280 -H 1024 --delay 0 -o master/homepage http://de.holidayinsider.com
python /Users/mfrischkorn/Applications/webkit2png/webkit2png -F -W 1280 -H 1024 --delay 0 -o test/homepage http://hi.test
compare master/homepage-full.png test/homepage-full.png  diff/homepage-full.png
compare master/homepage-full.png test/homepage-full.png \
         -compose Src -highlight-color White -lowlight-color Black \
         diff/homepage-mask.png
count=`convert diff/homepage-mask.png -format %c histogram:info: | grep "white" | sed -n 's/^ *\(.*\):.*$/\1/p'`
percent=`convert diff/homepage-mask.png -format "%[fx:100*$count/(w*h)]" info:`
echo $percent
#0.366188

 *
 */
public class Main {

    public Main() {

    }

    public void run(String[] args) throws Exception {
        String hostKey = null;
        String suiteName = null;

        if (args.length >= 1) {
            suiteName = args[0];
        }

        if (args.length >= 2) {
            hostKey = args[1];
        }

        // ask for suite name
        // TODO ask with number

        Scanner in = new Scanner(System.in);

        if (suiteName == null) {
            System.out.print("Enter suite name: ");
            suiteName = in.nextLine();
        }

        if (hostKey == null) {
            System.out.print("Enter host key: ");
            hostKey = in.nextLine();
        }
        in.close();

        // this unpacks the webkit2png shell script which is needed for execution.
        File f = new File("webkit2png.py");
        if (!f.exists()) {
            System.out.println("spawning webkit2png.py...");
            InputStream webkitInput = getClass().getClassLoader().getResourceAsStream("webkit2png.py");
            OutputStream out = new FileOutputStream(f);

            int len;
            byte[] buf = new byte[1024];
            while((len = webkitInput.read(buf, 0, 1024)) > 0) {
                out.write(buf, 0, len);
            }
            out.flush();
            out.close();
            webkitInput.close();
        }

        System.out.println("Running suite " + suiteName + " against " + hostKey);
        SkimmyTest t = new SkimmyTest(suiteName, hostKey);
        t.runTests();
    }


    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.run(args);
    }

    private void usage() {
        System.out.println("Usage: well, i am sure you can figure it out...");
        System.out.println("");
        System.out.println("  -suite <suite name>");
        System.out.println("  -host <host key>");
    }

}
