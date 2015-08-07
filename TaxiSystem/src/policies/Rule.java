package policies;

public abstract class Rule {
	private int RuleId;
	private String ruleDescription;

	public void makeARule() {
		setProposedRule();
		if (needRevision()) {
			reviseRule();
		}
		getApproval();
		publishRule();

	}

	public abstract void setProposedRule();

	public void getApproval() {
		System.out.println("Rule has been approved");
	}

	public void publishRule() {
		System.out.println("The following rule has been published");
		//		System.out.println("Rule Id: " + getRuleId());
		//		System.out.println("Rule description: " + getRuleDescription());
	}

	public boolean needRevision() {

		return true;
	}

	public abstract void reviseRule();

	public int getRuleId() {
		return RuleId;
	}

	public void setRuleId(int ruleId) {
		RuleId = ruleId;
	}

	public String getRuleDescription() {
		return ruleDescription;
	}

	public void setRuleDescription(String ruleDescription) {
		this.ruleDescription = ruleDescription;
	}

	public abstract void updateRules();



}
