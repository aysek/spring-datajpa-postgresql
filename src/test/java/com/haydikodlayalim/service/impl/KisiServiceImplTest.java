package com.haydikodlayalim.service.impl;

import com.haydikodlayalim.dto.KisiDto;
import com.haydikodlayalim.entity.Kisi;
import com.haydikodlayalim.repo.AdresRepository;
import com.haydikodlayalim.repo.KisiRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class KisiServiceImplTest {

    @InjectMocks//kisiServise nesnesinin bir instance ını yaratır test etmek için
    // o nesnenin de ihtiyaç duyduğu bileşenlerin mocklarını ona inject eder
    private KisiServiceImpl kisiService;

    @Mock //Mocklamak: çalışma zamanında onun gerçek olmayan birer kopyasını yaratma demektir.
    private  KisiRepository kisiRepository;
    @Mock
    private  AdresRepository adresRepository;

    @Test
    public void testSave(){
        KisiDto kisiDto=new KisiDto();
        kisiDto.setAdi("Test-name");
        kisiDto.setSoyadi("Test-soyadı");
        kisiDto.setAdresler(Arrays.asList("Test-Adress-1"));
        Kisi kisiMock=mock(Kisi.class);

        when(kisiMock.getId()).thenReturn(1L);//dbden gelen kişi nesnesinin idsi çağrılırsa 1 numaralı kayıt dönsün
        when(kisiRepository.save(ArgumentMatchers.any(Kisi.class))).thenReturn(kisiMock);
        KisiDto result=kisiService.save(kisiDto);

        assertEquals(result.getAdi(),kisiDto.getAdi());
        assertEquals(result.getId(),1L);

    }
}