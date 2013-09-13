package cz.startnet.utils.pgdiff.schema;

import java.util.List;

/**
 * Database schema utilities.
 * 
 * @author Alexander Levhsa
 */
public class PgDBUtils {

	/**
	 * Compares sizes first and does List.equals(List)
	 * only if sizes match.
	 * 
	 * @param left List1
	 * @param right List2
	 * @return true is Lists are equal
	 */
	public static boolean listsEqual(
			final List<?> left, final List<?> right) {
		return (left.size() == right.size()
				&& left.equals(right));
	}
}
