package common;
import java.util.ArrayList;

public class ReposSearchResult {

    public ArrayList<RepoExtendedResult> results = new ArrayList<>();

    public void addResult(RepoExtendedResult e)
    {
        results.add(e);
    }
}
