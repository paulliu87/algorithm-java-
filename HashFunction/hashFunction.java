import java.io.*;
// param: char[] string and the size of the hash table
// param: return the hashed index
// the hash function is sum of ascii(char) * 33 ^ index  % hash_size


public int hashCode(char[] string, int HASH_SIZE) {
	long result = 0;
	for (int i = 0; i < string.length; i++) {
		result = (result * 33 + ((int) (string[i]))) % HASH_SIZE;
	}

	return (int) result;
}
