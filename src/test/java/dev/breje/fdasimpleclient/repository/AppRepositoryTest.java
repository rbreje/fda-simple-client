package dev.breje.fdasimpleclient.repository;

import dev.breje.fdasimpleclient.exceptions.DuplicateDatabaseRecordException;
import dev.breje.fdasimpleclient.model.entity.DrugRecordEntity;
import dev.breje.fdasimpleclient.model.entity.ProductEntity;
import dev.breje.fdasimpleclient.model.entity.ProductsOfDrugRecordEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppRepositoryTest {

    private static final String EXPECTED_ID = "expectedId";

    @Mock
    private ProductEntity productEntityMock;
    @Mock
    private ProductsOfDrugRecordEntity productsOfDrugRecordEntityMock;
    @Mock
    private DrugRecordEntity drugRecordEntityMock;

    @MockBean
    private DrugRecordRepository drugRecordRepositoryMock;

    @MockBean
    private ProductRepository productRepositoryMock;

    @MockBean
    private ProductsOfDrugRecordEntityRepository productsOfDrugRecordEntityRepositoryMock;

    @Autowired
    private AppRepository appRepository;

    @Test(expected = DuplicateDatabaseRecordException.class)
    public void saveDrugRecord_whenValidEntity_thenSaveValue() throws DuplicateDatabaseRecordException {
        when(drugRecordRepositoryMock.findById(EXPECTED_ID)).thenReturn(Optional.of(drugRecordEntityMock));
        when(drugRecordEntityMock.getProducts()).thenReturn(Set.of(productsOfDrugRecordEntityMock));
        when(productsOfDrugRecordEntityMock.getProduct()).thenReturn(productEntityMock);

        appRepository.saveDrugRecord(drugRecordEntityMock);

        verify(productsOfDrugRecordEntityMock, times(1)).getProduct();
    }

    @Test
    public void saveDrugRecord_whenDuplicatedEntity_thenThrowException() throws DuplicateDatabaseRecordException {
        when(drugRecordRepositoryMock.findById(EXPECTED_ID)).thenReturn(Optional.empty());
        when(drugRecordEntityMock.getProducts()).thenReturn(Set.of(productsOfDrugRecordEntityMock));
        when(productsOfDrugRecordEntityMock.getProduct()).thenReturn(productEntityMock);

        appRepository.saveDrugRecord(drugRecordEntityMock);
    }

    @Test
    public void findDrugRecordById_whenRecordExist_thenReturnValue() {
        when(drugRecordRepositoryMock.findById(EXPECTED_ID))
                .thenReturn(Optional.of(drugRecordEntityMock));

        Optional<DrugRecordEntity> actual = appRepository.findDrugRecordById(EXPECTED_ID);

        assertTrue(actual.isPresent());
    }

    @Test
    public void findAllDrugRecords_whenDatabaseNotEmpty_thenReturnListOfValue() {
        when(drugRecordRepositoryMock.findAll())
                .thenReturn(Arrays.asList(drugRecordEntityMock));

        List<DrugRecordEntity> entities = appRepository.findAllDrugRecords();

        assertFalse(entities.isEmpty());
    }

}
