namespace java if4031

typedef bool boolean
typedef string String
struct ChannelLastMsg {
  1: i32 lastID,
  2: String channel,
}

service ServerService
{
	String regNick(1: String token, 2: String nick);
	String joinChannel(1: String token, 2: String channel);
	String leaveChannel(1: String token, 2: String channel);
	boolean saveMessage(1: String token, 2: String channel, 3: String message);
	boolean saveToDB(1: String token, 2: String channel, 3: String message);
	String getMessage(1: list<ChannelLastMsg> clm, 2: String token);
	String iSend(1: String token, 2: String message);
}