package org.example.json.data.csv.domain;

import org.example.api.LocationMetadataDTO;
import org.example.json.data.infrastructure.ValidationErrorException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class CSVServiceTest {

    @Test
    void shouldThrowExceptionWhenPassedAttributesThatNotExistInModel() {
        //given
        List<String> attributes = List.of("test", "_id");
        CSVService csvService = new CSVService(initDataForDummyClient());

        //when
        Assertions.assertThrows(ValidationErrorException.class, () -> csvService.getDataInCSVFormat(attributes));
    }

    @Test
    void shouldReturnCorrectDataInPassedFormat() {
        //given
        List<String> attributes = List.of("_type", "_id", "name");
        DummyDataClient dummyDataClient = initDataForDummyClient(TestDataGenerator.createLocationMetadataWithId(1L));
        CSVService csvService = new CSVService(dummyDataClient);

        //when
        String dataInCSVFormat = csvService.getDataInCSVFormat(attributes);

        //then
        Assertions.assertEquals("Position, 1, test", dataInCSVFormat);
    }

    @Test
    void shouldReturnCorrectDataForMoreThanOneRowInPassedFormat() {
        //given
        List<String> attributes = List.of("_type", "_id", "name");
        DummyDataClient dummyDataClient = initDataForDummyClient(
                TestDataGenerator.createLocationMetadataWithId(1L), TestDataGenerator.createLocationMetadataWithId(2L)
        );
        CSVService csvService = new CSVService(dummyDataClient);

        //when
        String dataInCSVFormat = csvService.getDataInCSVFormat(attributes);

        //then
        Assertions.assertEquals("Position, 1, test\nPosition, 2, test", dataInCSVFormat);
    }

    @Test
    void shouldReturnEmptyStringWhenThereIsNoDataToReturn() {
        //given
        List<String> attributes = List.of("_type", "_id", "name");
        DummyDataClient dummyDataClient = initDataForDummyClient();
        CSVService csvService = new CSVService(dummyDataClient);

        //when
        String dataInCSVFormat = csvService.getDataInCSVFormat(attributes);

        //then
        Assertions.assertTrue(dataInCSVFormat.isEmpty());
    }

    @Test
    void shouldReturnCorrectResultForAddOperationOfTwoAttributes() {
        //given
        List<String> operations = List.of("longitude+latitude");
        DummyDataClient dummyDataClient = initDataForDummyClient(
                TestDataGenerator.createLocationMetadataWithLongitudeAndLatitude(1d, 1d)
        );
        CSVService csvService = new CSVService(dummyDataClient);

        //when
        List<String> operationsResults = csvService.getOperationsResults(operations);

        //then
        Assertions.assertEquals(1, operationsResults.size());
        Assertions.assertEquals("2.00000", operationsResults.get(0));
    }

    @Test
    void shouldReturnCorrectResultForAddOperationOfTwoAttributesWithPositiveAndNegativeValues() {
        //given
        List<String> operations = List.of("longitude+latitude");
        DummyDataClient dummyDataClient = initDataForDummyClient(
                TestDataGenerator.createLocationMetadataWithLongitudeAndLatitude(1d, -1d)
        );
        CSVService csvService = new CSVService(dummyDataClient);

        //when
        List<String> operationsResults = csvService.getOperationsResults(operations);

        //then
        Assertions.assertEquals(1, operationsResults.size());
        Assertions.assertEquals("0.00000", operationsResults.get(0));
    }

    @Test
    void shouldReturnCorrectResultForMultiplyOperation() {
        //given
        List<String> operations = List.of("longitude*latitude");
        DummyDataClient dummyDataClient = initDataForDummyClient(
                TestDataGenerator.createLocationMetadataWithLongitudeAndLatitude(2d, 2d)
        );
        CSVService csvService = new CSVService(dummyDataClient);

        //when
        List<String> operationsResults = csvService.getOperationsResults(operations);

        //then
        Assertions.assertEquals(1, operationsResults.size());
        Assertions.assertEquals("4.00000", operationsResults.get(0));
    }

    @Test
    void shouldReturnCorrectResultForTwoTypesOfOperationsAddAndMultiply() {
        //given
        List<String> operations = List.of("longitude+latitude", "longitude*latitude");
        DummyDataClient dummyDataClient = initDataForDummyClient(
                TestDataGenerator.createLocationMetadataWithLongitudeAndLatitude(3d, 3d)
        );
        CSVService csvService = new CSVService(dummyDataClient);

        //when
        List<String> operationsResults = csvService.getOperationsResults(operations);

        //then
        Assertions.assertEquals(1, operationsResults.size());
        Assertions.assertEquals("6.00000, 9.00000", operationsResults.get(0));
    }

    @Test
    void shouldReturnCorrectResultForTwoTypesOfOperationsAddAndMultiplyForMoreThanOneLocationMetadata() {
        //given
        List<String> operations = List.of("longitude+latitude", "longitude*latitude");
        DummyDataClient dummyDataClient = initDataForDummyClient(
                TestDataGenerator.createLocationMetadataWithLongitudeAndLatitude(3d, 3d),
                TestDataGenerator.createLocationMetadataWithLongitudeAndLatitude(4d, 4d)
        );
        CSVService csvService = new CSVService(dummyDataClient);

        //when
        List<String> operationsResults = csvService.getOperationsResults(operations);

        //then
        Assertions.assertEquals(2, operationsResults.size());
        Assertions.assertEquals("6.00000, 9.00000", operationsResults.get(0));
        Assertions.assertEquals("8.00000, 16.00000", operationsResults.get(1));
    }

    private DummyDataClient initDataForDummyClient(LocationMetadataDTO... locationMetadata) {
        return new DummyDataClient(Arrays.asList(locationMetadata));
    }
}