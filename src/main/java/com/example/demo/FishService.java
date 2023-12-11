package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishService {

  private final FishMapper fishMapper;

  public FishService(FishMapper fishMapper) {
    this.fishMapper = fishMapper;
  }

  public List<Fish> getAllFish() {
    List<Fish> fishList = fishMapper.findAll();
    return fishList;
  }

  public Fish createFish(Fish fish) {
    // 作成ロジックを実装
    fishMapper.save(fish);
    return fish; // 修正: 挿入後のFishオブジェクトを返す
  }

  public Fish getFishById(Long id) {
    // IDを使用してFishを取得するロジックを実装
    Fish fish = fishMapper.findById(id).orElse(new Fish("魚がいません", "")); // 引数を受け取るコンストラクタを使用
    return fish;
  }

  public Fish updateFish(Long id, Fish fish) {
    // IDを使用してFishを更新するロジックを実装
    fishMapper.update(fish);
    return fish; // 修正: 更新後のFishオブジェクトを返す
  }

  public void deleteFish(Long id) {
    // IDを使用してFishを削除するロジックを実装
    fishMapper.deleteById(id);
  }
}
