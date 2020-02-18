package au.com.puffinpowered.filereader.domain;

public enum VCFFieldNames {
	CHROM("chromosome", 0),
	POS("position", 1),
	ID("identifier", 2),
	REF("reference base(s)", 3),
	ALT("alternate base(s)", 4);


	private int postion;
	private String name;

	VCFFieldNames(String name, int postion) {
		this.name = name;
		this.postion = postion;
	}

	public String getName() {
		return name;
	}

	public int getPostion() {
		return postion;
	}
}
