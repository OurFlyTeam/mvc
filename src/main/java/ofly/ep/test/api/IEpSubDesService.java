package ofly.ep.test.api;

import java.util.List;
import java.util.Map;

import ofly.ep.test.vo.EpSubDesVO;

public interface IEpSubDesService {
	List<EpSubDesVO> queryListByType(Map<String, Object> params);
}
