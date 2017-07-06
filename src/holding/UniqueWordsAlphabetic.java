package holding;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

import util.TextFile;

public class UniqueWordsAlphabetic {
	public static void main(String[] args) {
		Set<String> words = 
				new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		words.addAll(new TextFile("src"+ File.separator + 
				"holding"+ File.separator +
				"SetOperations.java", "\\W+"));
		System.out.println(words);
		
		//[A, add, addAll, added, args, B, C, class, Collections, contains, containsAll, D, E, F, from, G, H, HashSet, holding, I, import, in, J, java, K, L, M, main, N, new, package, Print, public, remove, removeAll, removed, Set, set1, set2, SetOperations, split, static, String, to, util, void, X, Y, Z]
	}
}
