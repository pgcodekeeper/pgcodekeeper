package ru.taximaxim.codekeeper.cli;

import java.io.IOException;

public abstract class RandomOutputArgumentsProvider extends ArgumentsProvider {

    public RandomOutputArgumentsProvider() {
        super();
    }

    public RandomOutputArgumentsProvider(String resName) {
        super(resName);
    }

    protected abstract String findRandomPart(String contents);

    protected abstract String getRandomReplacement();

    @Override
    public String getDiffFileContents() throws IOException {
        String contents = super.getDiffFileContents();
        return contents.replace(findRandomPart(contents), getRandomReplacement());
    }
}
