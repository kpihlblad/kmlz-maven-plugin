# KumuluzEE Maven Plugin

> A fixed Maven Plugin for the Kumuluz EE microservice framework

A quick fix for a small problem in the [official Kumuluzee Maven Plugin](https://github.com/kumuluz/kumuluzee) 

The target `kumuluzee:run` triggers the package goal phase before starting, to enable a one-liner build and start.

It also uses the 'exec' goal to spawn a new java process,
to avoid a conflict(?) between the Plexus Launcher and the Kumuluzee Launcher.


## Usage

Include the plugin in your project:

```xml
<plugin>
    <groupId>io.github.kpihlblad</groupId>
    <artifactId>kumuluzee-maven-plugin</artifactId>
    <version>${kumuluzee.version}</version>
</plugin>
```

### Goals

* __kumuluzee:copy-dependencies__
    
    Copy dependencies and prepare for execution in an exploded class and dependency runtime.


* __kumuluzee:repackage__

    Repackages existing JAR archives so that they can be executed from the command line using `java -jar`.
    
    ###### Parameters
    
    * __finalName__
    
        Final name of the generated "uber" JAR.
        
        __Default value is__: `${project.build.finalName}` or `${project.artifactId}-${project.version}`
        
    * __outputDirectory__
    
        Directory containing the generated JAR.
        
        __Default value is__: `${project.build.directory}`
    
* __kumuluzee:run__

    Run the application in an exploded class and dependency runtime.
