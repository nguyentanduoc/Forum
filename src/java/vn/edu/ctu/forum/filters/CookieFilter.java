/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vn.edu.ctu.forum.models.pojos.Member;
import vn.edu.ctu.forum.models.service.MemberService;
import vn.edu.ctu.forum.models.service.MemberServiceImpl;

/**
 *
 * @author NTD
 */
@WebFilter(filterName = "CookieFilter", urlPatterns = {"/*"})
public class CookieFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        String emailMember = "";
        String passMember = "";
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie ck : cookies) {
                if ("memberEmail".equals(ck.getName())) {
                    emailMember = ck.getValue();
                }
                if ("memberPass".equals(ck.getName())) {
                    passMember = ck.getValue();
                }
            }
            
            if (!emailMember.equals("") || !passMember.equals("")) {
                
                MemberService mbs = new MemberServiceImpl();
                Member m = mbs.login(emailMember, passMember);
                
                if (m != null) {
                    HttpSession session = req.getSession();
                    session.removeAttribute("member");
                    session.setAttribute("member", m);
                }
                
            }
        }
        chain.doFilter(req, response);
    }

    @Override
    public void destroy() {
    }

}
