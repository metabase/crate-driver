# Metabase CrateDB Driver (Community-Supported)

The Metabase CrateDB driver allows Metabase v0.32.0 or above to
connect to [CrateDB](https://crate.io/products/cratedb/) databases.
Instructions for installing it can be found below.

This driver is community-supported and is not considered part of the
core Metabase project. If you would like to open a GitHub issue to
report a bug or request new features, or would like to open a pull
requests against it, please do so in this repository, and not in the
core Metabase GitHub repository.

We will close issues or PRs concerning the Crate driver opened in the
core Metabase GitHub repository, and ask you to reopen them here.

## Obtaining the CrateDB Driver

### Where to find it

[Click here](https://github.com/metabase/crate-driver/releases/latest) to view the latest release of the Metabase CrateDB driver; click the link to download `crate.metabase-driver.jar`.

You can find past releases of the CrateDB driver [here](https://github.com/metabase/crate-driver/releases).


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


## Connecting to a CrateDB Dataset

1. Setup a connection by providing a **Name** and a **Host**. CrateDB
   supports having a connection pool of multiple hosts. This can be
   achieved by providing a comma-separated list of multiple
   `<host>:<psql-port>` pairs.

   ```
   host1.example.com:5432,host2.example.com:5432
   ```

2. Click the `Save` button. Done.

Metabase will now begin inspecting your CrateDB Dataset and finding
any tables and fields to build up a sense for the schema. Give it a
little bit of time to do its work and then you're all set to start
querying.


## Known limitations

* Columns/Fields of type `object_array` are deactivated and not
  exposed. However, their nested fields are listed and also supported
  for queries.


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


### License

Copyright © 2019 Metabase, Inc.

Distributed under the [Eclipse Public License](https://raw.githubusercontent.com/metabase/toucan/master/LICENSE.txt), same as Clojure.
