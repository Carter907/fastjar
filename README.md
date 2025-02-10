## FastJar

- First project utilizing the Java Compiler Framework.

A jar for building jars quickly.

### Usage

```
fastjar Main app
```
The first argument is the name of the class and the second is jar name.

### Build from source

Building from source is the recommended way to install.

Make sure you have gradle installed.

Next,
clone the repository:
```
git clone git@github.com:Carter907/fastjar
cd fastjar
gradle shadowJar
```

You should find the executable jar under `build/libs`

Next, I would create an alias to run this easily in the shell:

```
export fastjar="java -jar ~/[path to fastjar]"
```
