package LeetCode;

import java.util.Arrays;

public class DecryptHackingTime {

	static final String SAMPLE = "-Your friend, Alice";
    static String decrypt(String encrypted_message) {

        char[] cSampleArr = SAMPLE.replaceAll("[^a-zA-z]", "").toCharArray();
        char[] cMessageArr = encrypted_message.toCharArray();
        int[] code = new int[cSampleArr.length];
        
        int [] key = new int[]{8, 2, 5, 1, 2, 2, 0};        //Arrays.stream(key).forEach(System.out::println);

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        for(; j < cMessageArr.length ; i++, j++)
        {
        	 i %= key.length;
        	if((cMessageArr[j] >= 65 && cMessageArr[j] <= 90) || (cMessageArr[j] >= 97 && cMessageArr[j] <= 122))
        	{
        		if(cMessageArr[j] >= 65 && cMessageArr[j] <= 90)
        		{
        			char c = (char) (cMessageArr[j]-key[i]);
        			if(!((c >= 65 && c <= 90)))
            			c += 26;
            		sb.append(c);
        		}
        		else
        		{
        			char c = (char) (cMessageArr[j]-key[i]);
        			if(!((c >= 97 && c <= 122)))
            			c += 26;
            		sb.append(c);
        		}
        	}
        	else
        	{
        		sb.append(cMessageArr[j]);
        		i--;
        	}
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		
		System.out.println(decrypt("Otjfvknou kskgnl, K mbxg iurtsvcnb ksgq hoz atv. Vje xcxtyqrl vt ujg smewfv vrmcxvtg rwqr ju vhm ytsf elwepuqyez. -Atvt hrqgse, Cnikg"));
	}
}
