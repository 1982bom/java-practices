import java.io.*;
import java.util.*;

/**
 * solution for http://183.106.113.109/30stair/similar/similar.php?pname=similar
 */
class CompareSimilarWords {
	static boolean similar(SimilarWord s0, SimilarWord s1) {
		int res0 = minus(s0, s1);
		int res1 = minus(s1, s0);
		return (res0 == 0 || res0 == 1) && (res1 == 0 || res1 == 1);
	}

	static private int minus(SimilarWord s0, SimilarWord s1) {
		int res = 0, t;
		int[] alp0 = s0.get();
		int[] alp1 = s1.get();
		for (int i = 0; i < alp0.length; i++) {
			t = alp0[i] - alp1[i];
			if (t > 0) res += t;
		}
		return res;
	}
}

class SimilarWord {
	String 	word;
	int[] 	alphabets = new int[26];
	
	public SimilarWord(String word) throws UnsupportedEncodingException {
		this.word = word;
		Arrays.fill(alphabets, 0);
		byte[] bytes = word.toUpperCase().getBytes("ascii");
		byte[] offset = "A".getBytes("ascii");
		for (byte b : bytes) 
			alphabets[b - offset[0]]++;
	}

	// FIXME: remove this
	public int[] get() {
		return alphabets;
	}

	public boolean similar(SimilarWord s) {
		return CompareSimilarWords.similar(this, s);
	}

	public String toString() {
		return word;
	}
}

public class SimilarWords {

	String[] get(InputStream in) {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		List<String> l = new ArrayList<String>();
		String s;

		try {
			while ((s = br.readLine()) != null) {
				l.add(s);
			}
			l.remove(0);	// delete first line, # of words
			return l.toArray(new String[0]);
		} catch (IOException e) {
			return new String[0];
		}
	}

	public void solve() {
		String[] words = get(System.in);
		try {
			SimilarWord s = new SimilarWord(words[0]);
			for (int i = 1; i < words.length; i++) {
				SimilarWord t = new SimilarWord(words[i]);
				if (s.similar(t)) 
					System.out.println(t);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SimilarWords().solve();
	}
}
