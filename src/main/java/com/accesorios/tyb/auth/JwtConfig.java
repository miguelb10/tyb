package com.accesorios.tyb.auth;

public class JwtConfig {

	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEpgIBAAKCAQEAtBHKnCQvSkV56OaLiIi9bGZ8JjBQiZpFEYp1N8J8z41UTG4x\r\n" + 
			"H0k5tREYZYdd2tTrPmqz9gLMDHRUeHKHB7oe86Xcz3D7YXVxncgDqbBblQNwFeij\r\n" + 
			"CGwQqLecvGIQB7+7Xhs//8OqSmzIKsW7piV32cU7W9pOiT9tuQl6u/3kfQTy2sjN\r\n" + 
			"NbZkhyntHa47IwuuiR8GWrtyFCBh6xpHHqPJg1B3I3Tn8l3+9Te/gMZq46KnMDo3\r\n" + 
			"hOw2rvy/+DGeqwu1O76hZ/wiXh8maPskNf1lQYOQp2K/EsBD03avlPuIhj3Q4zfg\r\n" + 
			"6qjpZtbx/9P8ilwyh1TM4B+RTft10P/9PByVbQIDAQABAoIBAQCZp3DfihT8aIqd\r\n" + 
			"jVTVnfEdddpMb//ZW1XCoQZjHUeJiAy9521tR/vBISRTRo509CkEquKDc2GQ4xdN\r\n" + 
			"bFUC5/QPbqIcNUmcoS3hOFK/0qhjYHqdh1TPE/+nKH7LVVZedmI47EHRSrKeLXMk\r\n" + 
			"5HO6U9CQeDetqnxHq2NCeO9NSVpWvpo0TJhcL9JJyFOukDp20Z7nzh7ps1MTrY+W\r\n" + 
			"wKKBFVs5/rLiE7l8lrLG29YujPDwFl1tmd1dEPv1ffEiFeogIsSBpUdd8PJAJmFN\r\n" + 
			"mFjZmkjFGUtQUowvhaWBCgdG1N/0nf6QaQkq9A9gMfUEUp7sac4O3plPOv0O8P5c\r\n" + 
			"7FL7Ll1hAoGBAOP4t4T+JkW9O0cBcwdYVXCkqPPspO3YTmhJFH1TPMv4knft9Gox\r\n" + 
			"bYCspJdGhv3dEujg40+mbEuqtLkkO0Nsa22sFaFaEeZnPpMSYzyro8yc+r6/vRHq\r\n" + 
			"FO5nhhe1Qe7vX0ptR3/V/y1PZUuXzkT0byt5SFR/Pb1UGT53O5djCpNJAoGBAMo1\r\n" + 
			"Ygs5dj6rfNAAY9RYmkOUoVQEERoj7kTQ5JSNZc7USvRoFmnk4gMlEAhcN+4OynWh\r\n" + 
			"K2UHaxky/i45Rrn+fiB01MNgKVeDPbdlp9sUgUrlwe8uYNIPP/xnmQLE2474qdIy\r\n" + 
			"gHXdFqMjIkj6cnEGQ7MznqGrmALMIQtIAvnLBQ0FAoGBAIHDOPMCl1Zq+CrasFcl\r\n" + 
			"+Lw9fc4ajWa1ESxbLMaJcrnHq9eIIu+vYt0zaByTkJNAG1tjZwAXgt0vNd+MuA8Q\r\n" + 
			"z7WFlmpZkobLjdq5RLNsH7iAQloBWeWwkGmDk9g63GTc7Ci5O1GQxcdMwiPdLRQi\r\n" + 
			"7oSYbItsQgBatmPQCqOJRKPBAoGBAJVFq0cV+FBzUARNBWUws1DIXAAlsGpXtAFh\r\n" + 
			"JBz19P4mgd7DKCisKpyfs6I4UaGPka4ceGhwfYNwvWtqJOgRExLqrFY+msZbwCev\r\n" + 
			"B6cXEAs2aWAkIJ1xXI77+1yr7lkxAEyHs4VO3PM5cInnOKxvL3MO3EAE6IbIImyt\r\n" + 
			"kGTOlr/xAoGBANpPQCBkaIgx+CsgNxOh1jq0xUlyLqrmfVy6m/XwoJ99xrBJIgeH\r\n" + 
			"l3XPCFsfOvwVSkr7vRa0yaVjLSL1XDv8fIIFgtlGtQDcyEC4itUn6WT7mdsPbOra\r\n" + 
			"cFCp18WW7MFESzKqHcTtcYVu8cRc5KRnH/ohuflgm3mc3/6eyY/KdWoX\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtBHKnCQvSkV56OaLiIi9\r\n" + 
			"bGZ8JjBQiZpFEYp1N8J8z41UTG4xH0k5tREYZYdd2tTrPmqz9gLMDHRUeHKHB7oe\r\n" + 
			"86Xcz3D7YXVxncgDqbBblQNwFeijCGwQqLecvGIQB7+7Xhs//8OqSmzIKsW7piV3\r\n" + 
			"2cU7W9pOiT9tuQl6u/3kfQTy2sjNNbZkhyntHa47IwuuiR8GWrtyFCBh6xpHHqPJ\r\n" + 
			"g1B3I3Tn8l3+9Te/gMZq46KnMDo3hOw2rvy/+DGeqwu1O76hZ/wiXh8maPskNf1l\r\n" + 
			"QYOQp2K/EsBD03avlPuIhj3Q4zfg6qjpZtbx/9P8ilwyh1TM4B+RTft10P/9PByV\r\n" + 
			"bQIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";
}
