//package volos.service.implementation;
//
//import volos.service.StatisticsService;
//
//public class StatisticsServiceImpl implements StatisticsService {
//
////    public float getJumperPriceSum(List<Look> list) {
////        return (float) Stream.ofNullable(list).flatMap(Collection::stream).
////                filter(x -> x.getUpperClothes().equals(TypeOfUpperClothes.Jumper.getUpper_s())).
////                mapToDouble((Look::getPrice)).
////                sum();
////
////    }
////
////    public float getMaxPrice(List<Look> list) {
////        return (float) list.stream().
////                mapToDouble(Look::getPrice).
////                max().orElseThrow(NoSuchElementException::new);
////    }
////
////    public float getAveragePrice(List<Look> list) {
////        return (float) list.stream().
////                mapToDouble(Look::getPrice).
////                average().orElseThrow(NoSuchElementException::new);
////    }
////
////    public Map<Boolean, List<Look>> getGroupByCondition(List<Look> list, Predicate<Look> booleanCondition) {
////        return list.stream().
////                collect(Collectors.partitioningBy(booleanCondition));
////    }
////
////    public List<String> getMostPopularTypeOfUpperCloth(List<Wardrobe> wardrobeList) {
////
////        List<String> result = new ArrayList<>();
////        wardrobeList.stream()
////                .flatMap(x -> x.getLooks().stream())
////                .collect(Collectors.toList())
////                .stream()
////                .collect(Collectors.groupingBy(Look::isExpensive))
////                .forEach((key, value) -> value.stream()
////                        .collect(Collectors.groupingBy(x -> x.getUpperClothes().getTypeOfUpperClothes().toString(), Collectors.counting()))
////                        .entrySet()
////                        .stream()
////                        .max(Map.Entry.comparingByValue())
////                        .ifPresent(x -> result.add(x.getKey())));
////        return result;
////    }
//}
