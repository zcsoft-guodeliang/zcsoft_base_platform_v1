package com.zcsoft.common.utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.springframework.cache.ehcache.EhCacheCacheManager;

/**
 * CacheManager 2017年10月30日 下午2:07:08
 * 
 * @version 1.0.0 缓存管理
 */
public class CacheManager {
	private static net.sf.ehcache.Cache cache = null;
	private static net.sf.ehcache.CacheManager manager;
	
	
   /**
	public synchronized static void putConfigCache(
			net.sf.ehcache.CacheManager ehCacheManager, String cacheName) {
		configService = (ISysConfigService) SpringBeanUtil.getAppContext()
				.getBean("configService");
		try {
			Element element = new Element(CONFIGCACHE,
					configService.getSysConfigByName("customName"));
			cache = ehCacheManager.getCache(CONFIGCACHE);
			cache.put(element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}**/

	// 实例化cacheManager
	public  static  void getInstance() {
		if(null==manager){
			EhCacheCacheManager ehcacheManager = (EhCacheCacheManager) SpringBeanUtil
					.getAppContext().getBean("springCacheManager");
			manager=ehcacheManager.getCacheManager();
		}
	}

	public synchronized static void put(String cacheName, String key, Object value) {
		cache = manager.getCache(cacheName);
		Element element = new Element(key, value);
		cache.put(element);
	}

	public synchronized static Object get(String cacheName, String key) {
		Cache cache = manager.getCache(cacheName);
		Element element = cache.get(key);
		return element == null ? null : element.getObjectValue();
	}

	public synchronized static Cache get(String cacheName) {
		return manager.getCache(cacheName);
	}

	public synchronized static void remove(String cacheName, String key) {
		Cache cache = manager.getCache(cacheName);
		cache.remove(key);
	}
}
