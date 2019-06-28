package cn.edu.hainu.web.Servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckCodeServlet
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int width=100;//��֤��ͼƬ��
		int height=35;//��֤���ͼƬ��
		//1����һ���������ڴ��д���һ��ͼƬ��ͼƬ��ʽʹ��RGB
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//2����ͼƬ
		Graphics g=image.getGraphics();//�������ʶ���
		g.setColor(Color.white);//���û�����ɫ
		g.fillRect(0, 0, width, height);//���
		//���߿�
		g.setColor(Color.blue);
		g.drawRect(0, 0, width-1, height-1);
		//str��������������ֺ���ĸ
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuiopasdfghjklzxcvbnm1234567890";
		Random ran=new Random();//����һ���������
		StringBuilder sb=new StringBuilder();//StringBuilder��׷���ַ������ַ�������
		//forѭ������4������ַ�
		for(int i=1;i<=4;i++)
		{
			int index=ran.nextInt(str.length());//��������±�
			char ch=str.charAt(index);//��ȡ����ַ�
			sb.append(ch);//׷�Ӹ���֤�뵽sb������ȥ
			g.drawString(ch+"", width/5*i, height/2);//д��֤�룬���ڲ�ͬ��x����д��i��������λ��
		}
		String checkCode_session=sb.toString();
		//����֤�����session��
		request.getSession().setAttribute("CHECKCODE_SERVER", checkCode_session);
		//��������
		g.setColor(Color.green);
		//������������
		for(int i=0;i<10;i++) {
			int x1=ran.nextInt(width);
			int x2=ran.nextInt(width);
			int y1=ran.nextInt(height);
			int y2=ran.nextInt(height);
			g.drawLine(x1, y1, x2, y2);//�û��ʻ�������
		}
		//3��ͼƬ�����ҳ��չʾ
		ImageIO.write(image, "jpg", response.getOutputStream());
		
		
	}

protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		this.doPost(request, response);
		
	}
}
