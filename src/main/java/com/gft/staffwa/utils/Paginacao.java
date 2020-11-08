package com.gft.staffwa.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.ModelAndView;

public class Paginacao {
  static public void setPaginacao(ModelAndView mv, String rotaAtual, Pageable pageable, Long totalInstances) {

    int totalPaginas = getTotalPaginas(totalInstances, pageable);

    if (totalPaginas > 0) {
      List<Integer> nroPaginas = getListaDePaginas(pageable, totalPaginas);

      System.out.println(pageable);
      System.out.println(nroPaginas);

      addObjectsToModel(mv, nroPaginas, pageable, rotaAtual);
    }
  }

  private static List<Integer> getListaDePaginas(Pageable pageable, int totalPaginas) {

    int paginaAtual = pageable.getPageNumber();

    int paginasAnteriores = getPaginasAnteriores(paginaAtual);

    int proxPaginas = paginaAtual + 3 > totalPaginas ? totalPaginas : paginaAtual + 3;

    return IntStream.rangeClosed(paginasAnteriores, proxPaginas).boxed().collect(Collectors.toList());
  }

  private static int getProxPaginas(int paginaAtual) {
    // TODO MÉTODO PARA PRÓXIMAS PÁGINAS
    return 0;
  }

  private static int getPaginasAnteriores(int paginaAtual) {
    if (paginaAtual - 2 > 0) {
      return paginaAtual - 2;
    } else if (paginaAtual - 1 > 0) {
      return paginaAtual - 1;
    } else {
      return 1;
    }
  }

  private static int getTotalPaginas(long totalInstances, Pageable pageable) {
    return (int) Math.ceil((double) totalInstances / (double) pageable.getPageSize());
  }

  private static void addObjectsToModel(ModelAndView mv, List<Integer> nroPaginas, Pageable pageable,
      String rotaAtual) {
    mv.addObject("nroPaginas", nroPaginas);
    mv.addObject("paginaAtual", pageable.getPageNumber());
    mv.addObject("hasPrevious", pageable.hasPrevious());
    mv.addObject("rotaAtual", rotaAtual);
  }
}
