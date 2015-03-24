package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.IgnoredObjectPrefListEditor.BooleanChangeValues;

/**
 * Используется как контейнер для хранения настроек объекта для игнорирования
 *
 */
public class IgnoredObject {

    private String name;
    private boolean isRegular;
    private boolean ignoreContent;

    public IgnoredObject(String name, boolean isRegular, boolean ignoreContent) {
        this.name = name;
        this.isRegular = isRegular;
        this.ignoreContent = ignoreContent;
    }

    public String getName() {
        return name;
    }

    public boolean isRegular() {
        return isRegular;
    }

    public boolean isIgnoreContent() {
        return ignoreContent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegular(boolean isRegular) {
        this.isRegular = isRegular;
    }

    public void setIgnoreContent(boolean ignoreContent) {
        this.ignoreContent = ignoreContent;
    }
    
    public boolean match(String objName) {
        if (isRegular) {
            return Pattern.compile(name,
                            Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)
                                .matcher(objName).find();
        } else {
            return name.contains(objName);
        }
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        final int itrue = 1231;
        final int ifalse = 1237;
        int result = 1;
        result = prime * result + (ignoreContent ? itrue : ifalse);
        result = prime * result + (isRegular ? itrue : ifalse);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;
        if (obj instanceof IgnoredObject) {
            IgnoredObject other = (IgnoredObject) obj;
            eq = ignoreContent == other.ignoreContent
                    && isRegular == other.isRegular
                    && Objects.equals(name, other.name);
        }
        return eq;
    }
    
    @Override
    public String toString() {
        Long result = 0 | (isRegular? BooleanChangeValues.REGULAR.getStatusFlagValue() : 0)
                | (ignoreContent ? BooleanChangeValues.IGNORE_CONTENT.getStatusFlagValue() : 0);
        return name + " " + result;
    }
    
    public static LinkedList<IgnoredObject> parsePrefs(List<String> propertyValues) {
        LinkedList<IgnoredObject> result = new LinkedList<>();
        for (String prop : propertyValues) {
            IgnoredObject obj = parseLine(prop);
            if (obj != null) {
                result.add(parseLine(prop));
            }
        }
        return result;
    }
    
    static IgnoredObject parseLine(String line) {
        try {
            int lastSpace = line.lastIndexOf(' ');
            if (lastSpace == -1) {
                if (line.length() > 0) {
                    return new IgnoredObject(line, false, false);
                }
                return null;
            }
            String name = line.substring(0, lastSpace).trim();
            String pattern = line.substring(lastSpace + 1, line.length()).trim();
            int val = Integer.parseInt(pattern);
            boolean isRegular = (val & BooleanChangeValues.REGULAR
                    .getStatusFlagValue()) == BooleanChangeValues.REGULAR
                    .getStatusFlagValue();
            boolean ignoreContent = (val & BooleanChangeValues.IGNORE_CONTENT
                    .getStatusFlagValue()) == BooleanChangeValues.IGNORE_CONTENT
                    .getStatusFlagValue();
            return new IgnoredObject(name, isRegular, ignoreContent);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            Log.log(Log.LOG_ERROR,
                    "Object has unnormal format will be skipped", e);
            return null;
        }
    }
}
