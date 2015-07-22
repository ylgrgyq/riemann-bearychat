# riemann-bearychat

Sending your riemann event to bearychat.com.

## Usage



## Installing

You will need to build this module for now and push it on riemann’s classpath, for this you will need a working JDK, JRE and leiningen.
First build the project:
```
lein uberjar
```

Then push the standalone jar file one the machine(s) where riemann runs, for example,
/usr/lib/riemann/riemann-bearychat.jar.

Next change EXTRA_CLASSPATH to include /usr/lib/riemann/riemann-bearychat.jar.

Finally, you can start riemann and use exposed functions, provided you have load this plugin in your configuration.


## License

Copyright © 2015 ylgrgyq

Distributed under the [MIT License](http://opensource.org/licenses/MIT).
