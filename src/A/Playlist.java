package A;

public class Playlist {
    private Track currentTrack;
    private int size;
    private ArrayList[] trackList;

    public Playlist() {
        this.trackList = new ArrayList[6];
        for (int i = 0; i < trackList.length; i++) {
            trackList[i] = new ArrayList();
        }
        this.size = 0;
    }

    public void add(int id, String artist, String title, int length, int priority) {
        Track track = new Track(id, artist, title, length, priority);
        trackList[priority].addLast(track);
        System.out.println(trackList[priority]);
        this.size++;
    }

    public int remove(int id) {
        for (ArrayList tracks : trackList) {
            for (int i = 0; i < tracks.getSize(); i++) {
                if (tracks.getByIndex(i).getId() == id) {
                    tracks.remove(id);
                    System.out.println("removed");
                    break;
                }
            }
        }
        return 0;
    }

    public void play(int length) {
        for (ArrayList tracks : trackList) {
            for (int i = 0; i < tracks.getSize(); i++) {
                    break;
                }
            }
        }
    }

    public void skip() {

    }

    public String peek() {
        return "";
    }

    public String list() {
        String result = "";
        for (ArrayList tracks : trackList) {
            System.out.println(tracks.getSize());
            for (int i = 0; i < tracks.getSize(); i++) {
                result += trackToString(tracks.getByIndex(i));
            }
        }
        try {
            return result.substring(0, result.length() - 1);
        } catch (Exception e) {
            return result;
        }

    }
    public String history() {
        return "";
    }
    private String trackToString(Track track) {
        return track.getId() + ":" + track.getArtist() + ":" + track.getTitle() + ":" + track.getLength() + ":" + track.getPriority() + "\n";
    }
}
