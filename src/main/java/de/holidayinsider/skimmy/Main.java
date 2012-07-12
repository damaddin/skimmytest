package de.holidayinsider.skimmy;

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

    public static void main(String[] args) throws Exception {

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

        if (suiteName == null) {
            System.out.print("Enter suite name: ");
            Scanner in = new Scanner(System.in);
            suiteName = in.nextLine();
            in.close();
        }

        if (hostKey == null) {
            System.out.print("Enter host key: ");
            Scanner in = new Scanner(System.in);
            hostKey = in.nextLine();
            in.close();
        }

        System.out.println("Running suite " + suiteName + " against " + hostKey);
        SkimmyTest t = new SkimmyTest(suiteName, hostKey);
        t.runTests();
    }

    private void usage() {
        System.out.println("Usage: well, i am sure you can figure it out...");
        System.out.println("");
        System.out.println("  -suite <suite name>");
        System.out.println("  -host <host key>");
    }

}
