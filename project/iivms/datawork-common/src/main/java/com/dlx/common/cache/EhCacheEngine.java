package com.dlx.common.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class EhCacheEngine implements CacheEngine {

	private static Log log = LogFactory.getLog(EhCacheEngine.class);

	private CacheManager manager;

	public void init() {
		try {
			manager = CacheManager.create(DUMMY_FQN);
		} catch (CacheException ce) {
			log.error("EhCache 初始化错误", ce);
			throw new RuntimeException(ce);
		}
	}
	
	public void init(URL url){
		try {
			manager = CacheManager.create(url);
		} catch (CacheException ce) {
			log.error("EhCache 初始化错误", ce);
			throw new RuntimeException(ce);
		}
	}

	public void stop() {
		manager.shutdown();
	}

	public void add(String key, Object value) {
		if (log.isDebugEnabled()) {
			log.debug("使用键值 " + key + "  缓存 " + value);
		}
		add(DUMMY_FQN, key, value);
	}

	public void add(String fullyQualifiedName, String key, Object value) {
		if (!manager.cacheExists(fullyQualifiedName)) {
			try {
				manager.addCache(fullyQualifiedName);
			} catch (CacheException ce) {
				log.error(ce, ce);
				throw new RuntimeException(ce);
			}
		}
		Cache cache = manager.getCache(fullyQualifiedName);

		Element element = new Element(key, (Serializable) value);
		cache.put(element);
	}

	public Object get(String fullyQualifiedName, String key) {
		try {
			if (!manager.cacheExists(fullyQualifiedName)) {
				manager.addCache(fullyQualifiedName);
				return null;
			}
			Cache cache = manager.getCache(fullyQualifiedName);
			Element element = cache.get(key);
			if (element != null) {
				return element.getValue();
			}

			return null;
		} catch (CacheException ce) {
			log.error("不能关闭 EhCache!", ce);
			throw new RuntimeException(ce);
		}
	}

	public Object get(String fullyQualifiedName) {
		if (!manager.cacheExists(fullyQualifiedName)) {
			try {
				manager.addCache(fullyQualifiedName);
			} catch (CacheException ce) {
				log.error("不能关闭 EhCache!", ce);
				throw new RuntimeException(ce);
			}
		}
		Cache cache = manager.getCache(fullyQualifiedName);
		return cache;
	}

	public Collection getValues(String fullyQualifiedName) {
		try {
			if (!manager.cacheExists(fullyQualifiedName)) {
				manager.addCache(fullyQualifiedName);
				return new ArrayList();
			}
			Cache cache = manager.getCache(fullyQualifiedName);
			List values = new ArrayList(cache.getSize());
			List keys = cache.getKeys();

			for (Iterator iter = keys.iterator(); iter.hasNext();) {
				Object o = iter.next();
				Element element = cache.get(o);
				if (element != null) {
					values.add(element.getValue());
				}
			}

			return values;
		} catch (CacheException ce) {
			log.error("EhCache could not be shutdown", ce);
			throw new RuntimeException(ce);
		}
	}

	public void remove(String fullyQualifiedName, String key) {
		Cache cache = manager.getCache(fullyQualifiedName);

		if (cache != null) {
			cache.remove(key);
		}
	}

	public void remove(String fullyQualifiedName) {
		if (manager.cacheExists(fullyQualifiedName)) {
			manager.removeCache(fullyQualifiedName);
		}
	}

}
