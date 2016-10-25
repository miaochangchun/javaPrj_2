package com.miao.util;

public class PageUtil {
	/**
	 * ���캯������ҳ�����࣬����Ҫ֪��������������ǰҳ��ÿҳ��ʾ�ļ�¼���Լ��ܼ�¼����������������ͨ���������������������
	 * @param everyPage		ÿҳ��ʾ�ļ�¼��
	 * @param totalCount	�ܵļ�¼��
	 * @param currentPage	��ǰҳ
	 * @return
	 */
	public static Page createPage(int everyPage, int totalCount, int currentPage){
		everyPage = getEveryPage(everyPage);
		currentPage = getCurrentPage(currentPage);
		int totalPage = getTotalPage(everyPage, totalCount);
		int beginIndex = getBeginIndex(everyPage, currentPage);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);
		return new Page(everyPage, totalCount, totalPage, currentPage,beginIndex, hasPrePage, hasNextPage);
	}

	/**
	 * �Ƿ�����һҳ����ǰҳ������ҳ��û����һҳ����ҳ��Ϊ0��Ҳû����һҳ
	 * @param totalPage		��ҳ��
	 * @param currentPage	��ǰҳ
	 * @return
	 */
	private static boolean getHasNextPage(int totalPage, int currentPage) {
		// TODO Auto-generated method stub
		return currentPage == totalPage | totalPage == 0 ? false : true;
	}

	/**
	 * �Ƿ�����һҳ
	 * @param currentPage
	 * @return
	 */
	private static boolean getHasPrePage(int currentPage) {
		// TODO Auto-generated method stub
		return currentPage == 1 ? false : true;
	}
	
	/**
	 * ��ȡ��ǰҳ����ʼindex��
	 * @param everyPage		ÿҳ��ʾ�ļ�¼��
	 * @param currentPage	��ǰҳ
	 * @return
	 */
	private static int getBeginIndex(int everyPage, int currentPage) {
		// TODO Auto-generated method stub
		return (currentPage - 1) * everyPage;
	}

	/**
	 * ��ȡ�ܵ�ҳ�����ܵļ�¼��/ÿҳ��ʾ�ļ�¼��+1
	 * @param everyPage		ÿҳ���¼�¼��
	 * @param totalCount	�ܵļ�¼��
	 * @return
	 */
	private static int getTotalPage(int everyPage, int totalCount) {
		// TODO Auto-generated method stub
		int totalPage = 0;
		if (totalCount != 0 && totalCount % everyPage == 0) {
			totalPage = totalCount / everyPage;
		}else {
			totalPage = totalCount / everyPage + 1;
		}
		return totalPage;
	}
	
	/**
	 * ��õ�ǰҳ��ҳ����Ĭ��λ��һҳ������Ϊ���õ�ҳ��
	 * @param currentPage	��ǰҳ�����ò���
	 * @return
	 */
	private static int getCurrentPage(int currentPage) {
		// TODO Auto-generated method stub
		return currentPage == 0 ? 1 : currentPage;
	}

	/**
	 * ���ÿҳ��ʾ�ļ�¼����Ĭ����10����¼����������˾�ʹ�����õļ�¼��
	 * @param everyPage
	 * @return
	 */
	private static int getEveryPage(int everyPage) {
		// TODO Auto-generated method stub
		return everyPage == 0 ? 10 : everyPage;
	}
}
