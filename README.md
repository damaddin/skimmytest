SkimmyTest
==========

This is a alternative way to "automate" web testing. Most frameworks try to eliminate humans in automated testing of web
frontends but that has proven to be difficult to maintain and keep running as a process.

I believe its easier to embrace the human in testing as the number of detected mishaps is far greater than with any
automation. So, whats needed are tools that make scanning for errors faster because manually executing a test list is
tedious and boring.

SkimmyTest is a tool that creates screenshots of a given set of urls and diffs them against a "known good" set of screens.
In the good set you can exclude certain areas by just painting them black with your favorite image editor tool.
The only thing you have to do is create a testsuite configuration by putting in your set of urls that you want to check
and run it against your website.

Steps to get started
====================

To get started, take a set of urls and create a hosts.properties and a suite.properties in the suites directory. See the
example, that should make it easy to understand.

Run the tests by running the Main class (at the moment) and select suite and host to run against.

If the "wanted" Image does not exist it will be created so you get your set of screens.

Try running it again, it will start comparing the screens and probably find differences in places where you have
dynamic content. You might just ignore the dynamic part and just look at the screen diffs to determine whats wrong
in which case its reducing the time to wait for pages to load. Alternatively you start editing the wanted images
and black out the parts that you dont want to test.

Drawbacks
=========

It only runs on Mac OS - not because of my admiration of Apple but because the used webkit automation only runs there.
It does not cover cases of functional testing, workflow testing, asserting data correctness and such.
It is meant just for helping manual testing and not to replace it - go investigate htmlUnit or Selenium for that.
It cannot login to your page to get where you want to test.

Have fun!