package B;
/*
 * Copyright (c) 2022, KASTEL. All rights reserved.
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Utility class providing functionality to work with files.
 *
 * @author Moritz Gstuer
 * @version 1.0
 */
public final class FileHelper {
    /**
     * The line separator for terminating read-in text lines.
     */
    public static final String SEPARATOR = "\n";
    private static final String ERROR_INSTANTIATION = "Utility class cannot be instantiated.";

    /**
     * Creates a new instance of {@link FileHelper}.
     *
     * @throws IllegalStateException if constructor is called because
     *                               {@link FileHelper} is a utility class.
     */
    private FileHelper() {
        throw new IllegalStateException(ERROR_INSTANTIATION);
    }

    /**
     * Reads all lines from a file specified by its path. The lines are returned
     * joined together in a single string. The lines are terminated in this string
     * by the {@link #SEPARATOR}.
     *
     *
     * @param path the path of the file to be read
     * @return all lines of the file in a single string
     */
    public static String readAllLines(final String path) {
        final StringBuilder lines = new StringBuilder();
        try (Scanner fileReader = new Scanner(new File(path))) {
            while (fileReader.hasNextLine()) {
                lines.append(fileReader.nextLine()).append(SEPARATOR);
            }
        } catch (final IOException exception) {
            /*
             * You can assume that we only provide valid file paths. Therefore, there will
             * be no IOException when reading files during our tests. The following
             * RuntimeException does not need to be handled.
             */
            throw new IllegalArgumentException(exception);
        }
        return lines.toString();
    }
}
