SkimmyTest
==========

This is a alternative way to "automate" web testing. Most testing frameworks try to eliminate humans in
automated testing of web frontends but it has proven to be difficult to maintain the tests and run them regularly.

Rather than trying to eliminate humans we try to embrace the human in testing as the number of detected mishaps is
far greater than with any automation. So, whats needed are tools that make scanning for errors faster because manually
clicking through a test list is tedious and boring.

SkimmyTest is a tool that creates screenshots of a given set of urls and diffs them against a "known good" set of screens.
In the good set you can exclude certain areas by just painting them black with your favorite image editor tool.
The only thing you have to do is create a testsuite configuration by putting in your set of urls that you want to check
and run it against your website.

Steps to get started
====================

Take a set of urls and create a hosts.properties and a urilist.properties in the suites directory.
See the example, that should make it easy to understand.

Run the tests by running the Main class and select suite and host to run against.

If the "wanted" Image does not exist it will be created so you get your set of screens.

Try running it again, it will start comparing the screens and probably find differences in places where you have
dynamic content. You might just ignore the dynamic part and just look at the screen diffs to determine whats wrong.
Alternatively you start editing the wanted images and paint the parts black which you don't want it to compare.

Drawbacks
=========

It only runs on Mac OS - not because of my admiration of Apple but because the used webkit automation only runs there.
It does not cover cases of functional testing, workflow testing, asserting data correctness and such.
It is meant just for helping manual testing and not to replace it - go investigate htmlUnit or Selenium for that.
It cannot login to your page to get where you want to test.
It has a hardcoded 10-seconds delay to wait for loading to complete which of course slows down the test runs

Still, it's useful for us and it might be for you too.
Have fun!