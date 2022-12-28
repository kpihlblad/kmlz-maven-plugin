# KumuluzEE Maven Plugin

> A fixed Maven Plugin for the Kumuluz EE microservice framework

Applied patches in https://github.com/kpihlblad/kumuluzee/tree/maven-kumuluzee-run-exec to the official KumuluzEE Maven Plugin.

Triggering the package goal phase before starting, to enable a one-goal start using the `kumuluzee:run` goal.

Also uses the 'exec' goal to spawn a new java process,
to avoid a conflict(?) betweeb the Plexus Launcher and the Kumuluzee Launcher.



## Usage

Include the plugin in your project:

```xml
<plugin>
    <groupId>se.grynna.kmlz</groupId>
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
