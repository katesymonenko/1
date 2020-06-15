public enum CLI_COMMANDS {
	GREATER_THAN_AVERAGE ("--gta"),
	LESSER_THAN_AVERAGE ("--lta");

	private String commandName;
    CLI_COMMANDS(String commandName){
        this.commandName = commandName;
    }
    public String getCommandName(){ return commandName;}
}
