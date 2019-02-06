# Metabase CrateDB Driver (Community-Supported)

## Obtaining the CrateDB Driver

### Where to find it

### How to Install it

Metabase will automatically make the Crate driver if it finds the driver JAR in the Metabase plugins directory when it starts up.
All you need to do is create the directory (if it's not already there), move the JAR you just downloaded into it, and restart Metabase.

By default, the plugins directory is called `plugins`, and lives in the same directory as the Metabase JAR.

For example, if you're running Metabase from a directory called `/app/`, you should move the Crate driver JAR to `/app/plugins/`:

```bash
# example directory structure for running Metabase with Vertica support
/app/metabase.jar
/app/plugins/crate.metabase-driver.jar
```

If you're running Metabase from the Mac App, the plugins directory defaults to `~/Library/Application Support/Metabase/Plugins/`:

```bash
# example directory structure for running Metabase Mac App with Vertica support
/Users/camsaul/Library/Application Support/Metabase/Plugins/crate.metabase-driver.jar
```

If you are running the Docker image or you want to use another directory for plugins, you should specify a custom plugins directory by setting the environment variable `MB_PLUGINS_DIR`.

## Building the CrateDB Driver Yourself

### Prereqs: Install Metabase locally, compiled for building drivers

```bash
cd /path/to/metabase/source
lein install-for-building-drivers
```

### Build it

```bash
cd /path/to/crate-driver
lein clean
DEBUG=1 LEIN_SNAPSHOTS_IN_RELEASE=true lein uberjar
```

This will build a file called `target/uberjar/crate.metabase-driver.jar`; copy this to your Metabase `./plugins` directory.

## Bug fixes & pull requests

The Metabase CrateDB driver is community-supported and is not
considered part of the core Metabase project. If you would like to
open a GitHub issue to report a bug or request new features, or would
like to open a pull requests against it, please do so in this
repository, and not in the core Metabase GitHub repository.

We will close issues or PRs concerning the Crate driver opened in the
core Metabase GitHub repository, and ask you to reopen them here.



### License

Copyright © 2019 Metabase, Inc.

Distributed under the [Eclipse Public License](https://raw.githubusercontent.com/metabase/toucan/master/LICENSE.txt), same as Clojure.
