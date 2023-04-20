package coreFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlowMapper {
	
	public FlowMapper(){
        init();
    };

	private void init() {
		List<String> flow = Arrays.asList("welcome", "chooseLeagues", "chooseTeam", "alertOption", "league", "selectedLeague");
		List<String> leagueFlow = new ArrayList(flow);
		flowToPageMap.put(FLOW_NAMES.LEAGUE_FLOW, leagueFlow);
	}

	 private Map<FLOW_NAMES, List<String>> flowToPageMap = new HashMap();
	 
	 public List<String> getPageIds(FLOW_NAMES flow){ return Collections.unmodifiableList(flowToPageMap.get(flow)); }
}
