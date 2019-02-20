package at.vintagestory.modelcreator.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class ControlsDialog
{
	public static void show(JFrame parent)
	{
		JPanel container = new JPanel(new BorderLayout(20, 10));
		container.setBorder(new EmptyBorder(10, 10, 10, 10));

		JPanel leftPanel = new JPanel(new BorderLayout());

		JLabel message = new JLabel();
		message.setText("<html>"
				+ "<p><b>Drag&Drop of files</b></p>"
				+ "<ul>"
				+ "<li>Drop in model json files to open them</li>"
				+ "<li>Drop in png files to add textures</li>"
				+ "</ul>"
				+ "<p><b>UV Panel (Left)</b></p>"
				+ "<ul>"
				+ "<li>Hold left mouse button to move UV Rectangles</li>"
				+ "<li>Hold right mouse button to resize UV Rectangles (disables auto-uv)</li>"
				+ "</ul>"
				+ "<p><b>Model Pane (Middle)</b></p>"
				+ "<ul>"
				+ "<li>Hold left mouse button to move the camera</li>"
				+ "<li>Hold right mouse button to rotate the camera</li>"
				+ "<li>Use the mouse wheel to zoom in/out</li>"
				+ "<li>Hold CTRL and click the left mouse button to select a cube</li>"
				+ "<li>Hold CTRL and hold the left mouse button to move a cube</li>"
				+ "<li>Hold CTRL and hold the right mouse button to resize a cube</li>"
				+ "</ul>"
				+ "<p><b>Cube Properties Pane (Right)<b></p>"
				+ "<ul>"
				+ "<li>Hold SHIFT and click on any of the up/down arrows to modify in increments of 0.1</li>"
				+ "<li>Hold CTRL and click on any up/down arrows of the cubes position to not move the origin</li>"
				+ "<li>Focus any of the position/origin/size text fields and use mouse wheel to modify increase/decrease the size in -1/+1 (also works in conjunction with the CTRL and Shift modifiers)</li>"				
				+ "</ul>"		
				+ "<p><b>Face Pane (Right)<b></p>"
				+ "<ul>"
				+ "<li>Hold SHIFT+Copy Button and then SHIFT+Paste Button to quickly assign a texture to all the faces of a cube</li>"
				+ "</ul>"		
				+ "</html>"
		);
		leftPanel.add(message, BorderLayout.NORTH);

		container.add(leftPanel, BorderLayout.NORTH);

		JPanel btnGrid = new JPanel(new GridLayout(1, 4, 5, 0));

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(a ->
		{
			SwingUtilities.getWindowAncestor(btnClose).dispose();
		});
		btnGrid.add(btnClose);

		container.add(btnGrid, BorderLayout.SOUTH);

		JDialog dialog = new JDialog(parent, "Quick Controls", false);
		dialog.setResizable(false);
		dialog.setPreferredSize(new Dimension(500, 610));
		dialog.add(container);
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
		dialog.requestFocusInWindow();
	}
}
