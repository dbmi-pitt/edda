package edu.pitt.dbmi.edda.ldatests;

import java.util.HashMap;

import cc.mallet.types.Instance;
import cc.mallet.types.InstanceList;

public class TargetCacher {
	
	private final HashMap<String, String> targets = new HashMap<String, String>();
	
	public TargetCacher() {
	}
	
	public void cacheTarget(Instance instance) {
		String name = (String) instance.getName();
		String target = (String) instance.getTarget() ;
		if (targets.get(name) != null) {
			System.err.println("Trying to cache a duplicate instance name.");
		}
		else {
			targets.put(name, target);
		}
		
	}
	
	public String fetchTargetForInstance(Instance instance) {
		String name =  (String) instance.getName();
		String target = targets.get(name);
		target = target.replaceFirst("\\W*$", "");
		return target;
	}
	
	public void cacheTargets(InstanceList instanceList) {
		for (Instance instance : instanceList) {
			cacheTarget(instance);
		}
	}
	
	

}
