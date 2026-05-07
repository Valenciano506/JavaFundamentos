package javafundamentals.reflection.plugins;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PluginMetadata {
    String name();
}          